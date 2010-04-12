require zroadmap.inc

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/roadmap/roadmap-${PV}-src.tar.gz;name=archive \
           file://cross.patch;patch=1;pnum=2 \
           file://options.mk.patch;patch=1;pnum=2 \
           file://qt/qt2-fixes.patch;patch=1 \
           file://qt/qt_canvas.patch;patch=1 \
           file://qt/qt_main.patch;patch=1 \
           file://qt/roadmap_main.patch;patch=1 \
           file://roadmap_path.patch;patch=1 \
           file://roadmap.desktop.patch;patch=1 \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tar.gz;name=usdir"

S = "${WORKDIR}/roadmap-${PV}/src"

SRC_URI[archive.md5sum] = "773c1e4291177c5b7a887763f6cb83a6"
SRC_URI[archive.sha256sum] = "bfaa36f246dc01775268644c153a2c65f5e2009b45d19f72e3d06c83c59d3aed"
SRC_URI[usdir.md5sum] = "d669ae4a3567b0d5d3ff5db6351b4053"
SRC_URI[usdir.sha256sum] = "651f040408a9dfe3ece1d490cd808fc80e878fd39876f50f6772f9e5f9ee3674"
