DESCRIPTION = "ARToolKitPlus is a software library that can be used to calculate camera position and orientation relative to physical markers in real time. This enables the easy development of a wide range of Augmented Reality applications."
LICENSE = "GPLv3"

DEPENDS = "libxi gstreamer virtual/libx11 freeglut virtual/libgl"

SRC_URI = "http://edge.launchpad.net/artoolkitplus/trunk/${PV}/+download/artoolkitplus-${PV}.tar.bz2;name=archive \
"

SRC_URI[archive.md5sum] = "385d72a3222702d775c9517a18d8fd83"
SRC_URI[archive.sha256sum] = "e1189ab1eaba97cecb043875137046efe03b8d6aceed0916933f2d7776c1a971"


SCONS_FIX_ENV = "1"
inherit scons 

FILES_${PN} += "${libdir}/*.so"

