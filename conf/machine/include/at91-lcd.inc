# Common description for Atmel ARM processors with LCD controller

#PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
#PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive-1300"
#PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
#PREFERRED_PROVIDER_xserver = "xserver-xorg"
PREFERRED_PROVIDER_xserver = "xserver-kdrive"
#XSERVER = "xserver-kdrive-fbdev"
#XSERVER = "xserver-xorg \
#           xf86-input-evdev \
#           xf86-input-mouse \
#           xf86-input-tslib \
#           xf86-video-fbdev \
#           xf86-input-keyboard"

# Angstrom defines:
#PREFERRED_VERSION_xserver-kdrive = "1.4.0.90"
#PREFERRED_VERSION_xserver-kdrive = "1.6.1"

MACHINE_FEATURES += "screen touchscreen keyboard"

# Some options we disable for now
# MACHINE_FEATURES += "apm"
# MACHINE_FEATURES += "lcd"
# MACHINE_FEATURES += "bluetooth wifi irda phone gps"
# MACHINE_FEATURES += "mmc mmcroot fat"
# MACHINE_FEATURES += "i2c spi serial"
# MACHINE_FEATURES += "sound libogg libvorbis"


