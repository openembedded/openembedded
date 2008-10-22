DESCRIPTION = "Necessary packages for Enlightenment on Mamona"
LICENSE = "MIT"
PR = "r2"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
eet \
embryo \
imlib2 \
edb \
evas \
libevas-engine-software-x11 \
libevas-engine-software-16 \
libevas-engine-software-16-x11 \
libevas-saver-eet \
libevas-saver-edb \
libevas-saver-jpeg \
libevas-saver-tiff \
libevas-loader-eet \
libevas-loader-edb \
libevas-loader-jpeg \
libevas-loader-tiff \
ecore \
efreet \
edje \
etk \
ewl \
epeg \
esmart \
epsilon \
emotion \
enhance \
edbus \
e-wm \
"
