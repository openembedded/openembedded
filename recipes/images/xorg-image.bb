XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-tslib \
           xf86-video-fbdev "

require x11-image.bb

export IMAGE_BASENAME = "xorg-image"
