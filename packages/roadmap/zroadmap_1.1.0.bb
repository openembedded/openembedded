require zroadmap.inc

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/roadmap/roadmap-${PV}-src.tar.gz \
           file://cross.patch;patch=1;pnum=2 \
           file://options.mk.patch;patch=1;pnum=2 \
           file://qt/qt2-fixes.patch;patch=1 \
           file://qt/qt_canvas.patch;patch=1 \
           file://qt/qt_main.patch;patch=1 \
           file://qt/roadmap_main.patch;patch=1 \
           file://roadmap_path.patch;patch=1 \
           file://roadmap.desktop.patch;patch=1 \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tar.gz"

S = "${WORKDIR}/roadmap-${PV}/src"
