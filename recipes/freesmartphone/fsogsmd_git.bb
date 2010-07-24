require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.3"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "libfsoresource libgsm0710mux ppp"
# DEPENDS += "msmcommd"

EXTRA_OECONF_append = "\
  --enable-libgsm0710mux \
#  --enable-modem-qualcomm-palm \
"

CONFFILES_${PN} = "${sysconfdir}/freesmartphone/conf/openmoko_gta/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/palm_pre/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_dream/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_msm/fsogsmd.conf \
                  "
