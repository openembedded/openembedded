# kernel
PREFERRED_PROVIDER_virtual/kernel = "linux-msm7xxxx"

# xserver
PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
XSERVER = "xserver-kdrive-fbdev"

# capability database
MACHINE_DISPLAY_WIDTH_PIXELS = "480"
MACHINE_DISPLAY_HEIGHT_PIXELS = "640"

# use this for overrides
MACHINE_CLASS = "htc-msm7"

# features
MACHINE_FEATURES = "kernel26 touchscreen screen phone gps usb keyboard"

# CPU
require conf/machine/include/tune-arm1136-novfp.inc

