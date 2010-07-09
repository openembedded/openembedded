require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.2"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "libfsoresource libgsm0710mux ppp msmcommd"

SRC_URI_append_om-gta01 = " file://0001-fsogsmd-update-sysfs-node-in-config-for-openmoko_gta.patch;striplevel=2"
SRC_URI_append_om-gta02 = " file://0001-fsogsmd-update-sysfs-node-in-config-for-openmoko_gta.patch;striplevel=2"

EXTRA_OECONF_append = "\
  --enable-libgsm0710mux \
  --enable-modem-qualcomm-palm \
"

CONFFILES_${PN} = "${sysconfdir}/freesmartphone/conf/openmoko_gta/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/palm_pre/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_dream/fsogsmd.conf \
                   ${sysconfdir}/freesmartphone/conf/htc_qualcomm_msm/fsogsmd.conf \
                  "
