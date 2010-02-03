# kernel
PREFERRED_PROVIDER_virtual/kernel = "linux-qsd8"

# xserver
PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"

XSERVER = " \
	xserver-xorg \
	xserver-xorg-extension-glx \
	xserver-xorg-extension-dri \
	xf86-input-evtouch \	
	xf86-input-evdev \
	xf86-input-mouse \
	xf86-input-keyboard \
	xf86-video-msm \
"

# capability database
MACHINE_DISPLAY_WIDTH_PIXELS = "480"
MACHINE_DISPLAY_HEIGHT_PIXELS = "640"

# use this for overrides
MACHINE_CLASS = "htc-qsd8"

# features
MACHINE_FEATURES = "kernel26 touchscreen screen phone gps usb keyboard"

# CPU
TARGET_ARCH = "arm"
require conf/machine/include/tune-cortexa8.inc
