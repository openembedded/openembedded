require gnash-minimal.inc


PR = "r4"

PV = "0.8.3+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous:anonymous@cvs.sv.gnu.org/sources/gnash;module=gnash"
SRC_URI += "file://libtool-2.2.patch;patch=1 \
            file://libintl.patch;patch=1 \
            file://fix-trunc.diff;patch=1"

S = ${WORKDIR}/gnash


do_configure_prepend() {
	sed -i -e 's:dnl AC_CHECK_LIB(m, trunc:AC_CHECK_LIB(m, trunc:g' ${S}/configure.ac
}


