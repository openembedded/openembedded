require xorg-app-common.inc
PE = "1"

DESCRIPTION = "adjust backlight brightness using RandR extension"

DEPENDS += " virtual/libx11 libxrender libxrandr"
