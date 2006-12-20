DESCRIPTION = "Links is graphics and text mode WWW \
browser, similar to Lynx."
HOMEPAGE = "http://links.twibright.com/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "jpeg libpng flex openssl zlib"

LPV = "${@bb.data.getVar("PV",d,1).split("+")[1]}"

SRC_URI = "http://links.twibright.com/download/links-${LPV}.tar.bz2 \
           file://ac-prog-cxx.patch;patch=1 \
           file://cookies-save-0.96.patch;patch=1 \
           file://links-2.1pre17-fix-segfault-on-loading-cookies.patch;patch=1"

inherit autotools

S = "${WORKDIR}/links-${LPV}"

