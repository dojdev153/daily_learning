import numpy as np
import matplotlib.pyplot as plt

v0 = 25.0
g = 9.8
alpha = np.deg2rad(53.13)

v0x = v0 * np.cos(alpha)
v0y = v0 * np.sin(alpha)

t = np.linspace(0, 3.0, 200)

x = v0x * t
y = v0y * t - 0.5 * g * t**2

plt.figure(figsize=(10, 5))
plt.plot(x, y, label="Projectile Path")
plt.xlabel("Horizontal distance x (m)")
plt.ylabel("Vertical height y (m)")
plt.title("Projectile Trajectory")
plt.grid(True)
plt.legend()
plt.tight_layout()
plt.show()
