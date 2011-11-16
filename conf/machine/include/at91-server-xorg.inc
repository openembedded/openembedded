# Common description for Atmel ARM processors with LCD controller
# xserver-xorg version

PREFERRED_VERSION_xserver-common = "1.34"
PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-input-tslib \
           xf86-video-fbdev \
           xf86-input-keyboard"

include conf/machine/include/at91-lcd.inc
