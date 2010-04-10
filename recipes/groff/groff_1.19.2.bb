DESCRIPTION = "GNU roff"
SECTION = "base"
LICENSE = "GPL"
PR = "r6"

SRC_URI = "http://ftp.gnu.org/gnu/groff/groff-${PV}.tar.gz \
	           file://Makefile.in.patch;patch=1 \
	           file://Makefile.sub.patch;patch=1 \
	           file://groff.patch;patch=1"

inherit autotools

PARALLEL_MAKE = ""
# prefix and exec-prefix are broken and the .in file is broken too
# and can't be autoreconf'ed, so specify every dir
EXTRA_OECONF="--without-x --prefix=${D} --exec-prefix=${D} --bindir=${D}${bindir} --datadir=${D}${datadir} --mandir=${D}${datadir}/man --infodir=${D}${datadir}/info --with-appresdir=${D}${datadir}"
EXTRA_OEMAKE = "INSTALL_INFO=:"

do_configure() {
	oe_runconf
}

#
# The installer refuses to do anything if the prefix directory does not
# already exist, so create it manually before the standard install runs.
#
do_install_prepend() {
	install -m 0755 -d ${D}
}

SRC_URI[md5sum] = "f7c9cf2e4b9967d3af167d7c9fadaae4"
SRC_URI[sha256sum] = "d864fbd0bf6dea24e4f71736da9902a1cae86d0a1a893b5fe17118927257ec3e"
