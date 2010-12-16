DEPENDS = "libdce gst-plugins-base"

LICENSE = "LGPLv2.1"

inherit autotools

PV = "0.10.0"
PR = "r2"
PR_append = "+gitr${SRCREV}"

SRCREV = "bd235864a96fe9fc06df69bc9fc457d0408d9756"
SRC_URI = "git://github.com/robclark/gst-ducati.git;protocol=git \
           http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-0.10.31.tar.bz2;name=archive \
"

SRC_URI[archive.md5sum] = "a21fb08bdb578d972c7c14e77da8fbb6"
SRC_URI[archive.sha256sum] = "7f737e6d047c1ebeb4e1e0725fc377c5d9f12ee89186de7960be3cbba709ab84"

S = "${WORKDIR}/git"

acpaths = "-I m4 -I common/m4"

do_configure_prepend () {
	rm -rf ${S}/common ${S}/po
    cp -Rf ${WORKDIR}/gstreamer-0.10.31/common ${S}/
    cp -Rf ${WORKDIR}/gstreamer-0.10.31/po ${S}/

    if test -f po/Makefile.in.in;
    then
      patch -p0 -R < common/gettext.patch
    fi
    autopoint --force
    patch -p0 < common/gettext.patch
}

