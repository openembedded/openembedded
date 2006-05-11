DESCRIPTION = "Enlightenment Window Mananger Library"
DEPENDS = "virtual/evas virtual/ecore edje eet embryo"
LICENSE = "MIT"
PR = "r2"

inherit efl

SRC_URI = "${E_URI}/enlightenment-${PV}.tar.gz"
S = "${WORKDIR}/enlightenment-${PV}"

PROFILE = "LOWRES_PDA"
PROFILE_c7x0 = "HIRES_PDA"
PROFILE_tosa = "HIRES_PDA"
PROFILE_spitz = "HIRES_PDA"
PROFILE_akita = "HIRES_PDA"

EXTRA_OECONF = "--with-profile=${PROFILE} \
                --with-edje-cc=${STAGING_BINDIR}/edje_cc \
                --x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR}"

do_compile() {
	oe_runmake -C src/lib
}

headers = "E_Lib.h ../bin/e*.h"

do_install() {
	oe_runmake -C src/lib install DESTDIR=${D}
}
