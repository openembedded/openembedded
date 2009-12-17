DESCRIPTION = "The OpenGL Extension Wrangler Library (GLEW) is a cross-platform open-source C/C++ extension loading library."
SECTION = "libs"
LICENSE = "Modified BSD License, Mesa 3-D License, Khronos License"

DEPENDS = "virtual/libx11 virtual/libgl libxext libxi libxmu"

PR = "r1"


SRC_URI = "${SOURCEFORGE_MIRROR}/project/glew/glew/1.5.1/glew-1.5.1-src.tgz \
           file://autotools.patch;patch=1 \
          "

inherit autotools lib_package

S = "${WORKDIR}/glew"

