DESCRIPTION = "Implementation of the Stringprep, Punycode and IDNA specifications defined by the IETF Internationalized Domain Names (IDN) working group."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r0"

inherit pkgconfig autotools

SRC_URI = "http://alpha.gnu.org/gnu/libidn/libidn-${PV}.tar.gz"

EXTRA_OECONF = " --disable-tld"

do_configure_prepend () {
	autoreconf -f -i -s
}

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "440835808c577073db7d571357223dce"
SRC_URI[sha256sum] = "4f707c189259d7b3dda908d78a995366d388fe051aa3554b82cb324426997a23"
