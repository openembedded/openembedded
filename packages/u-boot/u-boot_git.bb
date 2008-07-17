require u-boot.inc
PR="r11"

SRCREV_davinci-sffsdr = "699f05125509249072a0b865c8d35520d97cd501"
SRCREV_davinci-dvevm = "699f05125509249072a0b865c8d35520d97cd501"
SRCREV_beagleboard = "bde63587622c4b830a27d1ddf7265843de9e994f"
SRCREV_neuros-osd2 = "70ee511d37ca99afee00edc27be36d0af2832bbc"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git "
SRC_URI_sequoia = "git://www.denx.de/git/u-boot.git;protocol=git;tag=cf3b41e0c1111dbb865b6e34e9f3c3d3145a6093 "
SRC_URI_neuros-osd2 = "git://git.neurostechnology.com/git/u-boot;protocol=git;branch=neuros"

SRC_URI_append_beagleboard = "file://base.patch;patch=1 \
                              file://name.patch;patch=1 \
                              file://armv7-a.patch;patch=1 \
                             "

SRC_URI_neuros-osd2 += "file://Makefile-fix.patch;patch=1"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
