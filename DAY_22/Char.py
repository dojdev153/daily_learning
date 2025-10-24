from direct.showbase.ShowBase import ShowBase
from direct.actor.Actor import Actor
from panda3d.core import loadPrcFileData

# Optional: Enable window resizing and other configs
loadPrcFileData('', 'win-size 800 600')
loadPrcFileData('', 'show-frame-rate-meter 1')

class MyGame(ShowBase):
    def __init__(self):
        ShowBase.__init__(self)
        
        # Load the environment model
        self.environ = self.loader.loadModel("models/environment")
        self.environ.reparentTo(self.render)
        self.environ.setScale(0.25, 0.25, 0.25)
        self.environ.setPos(-8, 42, 0)
        
        # Load the panda actor (3D character)
        self.pandaActor = Actor("models/panda-model", {"walk": "models/panda-walk4"})
        self.pandaActor.setScale(0.005, 0.005, 0.005)  # Scale down the model
        self.pandaActor.reparentTo(self.render)
        self.pandaActor.loop("walk")  # Play the walk animation
        
        # Set up camera to follow the character
        self.camera.setPos(0, -20, 5)  # Position camera behind the panda
        self.camera.lookAt(self.pandaActor)
        
        # Enable keyboard controls
        self.keys = {"forward": False, "backward": False, "left": False, "right": False}
        self.accept("arrow_up", self.setKey, ["forward", True])
        self.accept("arrow_up-up", self.setKey, ["forward", False])
        self.accept("arrow_down", self.setKey, ["backward", True])
        self.accept("arrow_down-up", self.setKey, ["backward", False])
        self.accept("arrow_left", self.setKey, ["left", True])
        self.accept("arrow_left-up", self.setKey, ["left", False])
        self.accept("arrow_right", self.setKey, ["right", True])
        self.accept("arrow_right-up", self.setKey, ["right", False])
        
        # Add a task for updating movement
        self.taskMgr.add(self.update, "update")
    
    def setKey(self, key, value):
        self.keys[key] = value
    
    def update(self, task):
        dt = globalClock.getDt()  # Delta time for smooth movement
        speed = 10  # Movement speed
        
        if self.keys["forward"]:
            self.pandaActor.setZ(self.pandaActor, speed * dt)
        if self.keys["backward"]:
            self.pandaActor.setZ(self.pandaActor, -speed * dt)
        if self.keys["left"]:
            self.pandaActor.setX(self.pandaActor, -speed * dt)
        if self.keys["right"]:
            self.pandaActor.setX(self.pandaActor, speed * dt)
        
        # Update camera to follow
        self.camera.setPos(self.pandaActor.getX(), self.pandaActor.getY() - 20, 5)
        self.camera.lookAt(self.pandaActor)
        
        return task.cont  # Continue the task

app = MyGame()
app.run()