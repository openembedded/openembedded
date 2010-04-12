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



SRC_URI[md5sum] = "2930626e627df49b45192a722cedc8a6"
SRC_URI[sha256sum] = "94cd595fe1ae130b8490d5690c7665d15536554473ad648ed46fc0ac3f383a80"
