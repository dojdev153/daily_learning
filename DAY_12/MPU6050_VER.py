import numpy as np
import serial
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from matplotlib.animation import FuncAnimation

PORT = 'COM6'
BAUD = 115200
ser = serial.Serial(PORT, BAUD, timeout=1)

# Define satellite vertices (cube + panels)
body = np.array([[-0.2,-0.2,-0.2],[0.2,-0.2,-0.2],[0.2,0.2,-0.2],[-0.2,0.2,-0.2],
                 [-0.2,-0.2,0.2],[0.2,-0.2,0.2],[0.2,0.2,0.2],[-0.2,0.2,0.2]])
panels = np.array([[-0.5,0,0],[0.5,0,0],[-0.5,0,0.1],[0.5,0,0.1]])

edges = [(0,1),(1,2),(2,3),(3,0),(4,5),(5,6),(6,7),(7,4),
         (0,4),(1,5),(2,6),(3,7)]

fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.set_xlim([-1,1]); ax.set_ylim([-1,1]); ax.set_zlim([-1,1])
lines = [ax.plot([],[],[], 'b')[0] for _ in range(len(edges))]
panel_lines = [ax.plot([],[],[], 'r')[0] for _ in range(4)]

def rotation_matrix(yaw,pitch,roll):
    y = np.radians(yaw); p = np.radians(pitch); r = np.radians(roll)
    Rx = np.array([[1,0,0],[0,np.cos(p),-np.sin(p)],[0,np.sin(p),np.cos(p)]])
    Ry = np.array([[np.cos(r),0,np.sin(r)],[0,1,0],[-np.sin(r),0,np.cos(r)]])
    Rz = np.array([[np.cos(y),-np.sin(y),0],[np.sin(y),np.cos(y),0],[0,0,1]])
    return Rz @ Ry @ Rx

def update(frame):
    line = ser.readline().decode(errors='ignore').strip()
    parts = line.split(',')
    if len(parts) != 3:
        return lines + panel_lines
    pitch, roll, yaw = map(float, parts)
    R = rotation_matrix(yaw,pitch,roll)
    body_rot = body @ R.T
    panels_rot = panels @ R.T

    for idx,(i,j) in enumerate(edges):
        lines[idx].set_data([body_rot[i,0],body_rot[j,0]],
                            [body_rot[i,1],body_rot[j,1]])
        lines[idx].set_3d_properties([body_rot[i,2],body_rot[j,2]])

    # draw panels as simple lines
    panel_lines[0].set_data([panels_rot[0,0],panels_rot[1,0]], [panels_rot[0,1],panels_rot[1,1]])
    panel_lines[0].set_3d_properties([panels_rot[0,2],panels_rot[1,2]])
    panel_lines[1].set_data([panels_rot[0,0],panels_rot[2,0]], [panels_rot[0,1],panels_rot[2,1]])
    panel_lines[1].set_3d_properties([panels_rot[0,2],panels_rot[2,2]])
    panel_lines[2].set_data([panels_rot[1,0],panels_rot[3,0]], [panels_rot[1,1],panels_rot[3,1]])
    panel_lines[2].set_3d_properties([panels_rot[1,2],panels_rot[3,2]])
    panel_lines[3].set_data([panels_rot[2,0],panels_rot[3,0]], [panels_rot[2,1],panels_rot[3,1]])
    panel_lines[3].set_3d_properties([panels_rot[2,2],panels_rot[3,2]])

    return lines + panel_lines

ani = FuncAnimation(fig, update, interval=30, blit=False)
plt.show()
