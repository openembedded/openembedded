require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.0"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "libfsoresource libgsm0710mux libgisi ppp"

EXTRA_OECONF_append = "\
  --enable-libgsm0710mux \
  --enable-modem-nokia-isi \
"

# On the palmpre we need the msmcomm daemon to talk to the modem
PACKAGE_ARCH_palmpre = "${MACHINE_ARCH}"
DEPENDS_append_palmpre = " msmcomm-specs"
RDEPENDS_append_palmpre = " msmcommd"
EXTRA_OECONF_append_palmpre = " --enable-modem-qualcomm-palm"

CONFFILES_${PN} = "${sysconfdir}/freesmartphone/conf/openmoko_gta/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/palm_pre/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_dream/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_msm/fsogsmd.conf \
                  "
