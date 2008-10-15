DESCRIPTION = "Frontends for SANE"
DEPENDS = "virtual/libx11 gimp sane-backends"
LICENSE = "LGPL"

PR = "r0"

SRC_URI = "ftp://ftp.sane-project.org/pub/sane/old-versions/sane-frontends-${PV}/sane-frontends-${PV}.tar.gz \
	"

inherit autotools

EXTRA_OECONF = "--disable-translations"

PACKAGES =+ "scanadf  xcam  xscanimage"

FILES_scanadf = "${bindir}/scanadf"
FILES_xcam = "${bindir}/xcam"
FILES_xscanimage = "${bindir}/xscanimage ${datadir}/sane"


