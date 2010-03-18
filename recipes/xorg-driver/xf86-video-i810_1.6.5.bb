require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "I810 for X11"

DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"

SRC_URI[archive.md5sum] = "fc1e0da3430551bf25a7babf7ccfd3bf"
SRC_URI[archive.sha256sum] = "30d0cd555d8b8b5bb53d93eaae1ad2aecb5c94a760e2346d60b6e194c254e40f"
