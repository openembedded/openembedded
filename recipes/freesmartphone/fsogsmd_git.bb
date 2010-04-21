require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.1"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "libfsoresource libgsm0710mux ppp msmcommd"

EXTRA_OECONF_append = "\
  --enable-libgsm0710mux \
  --enable-modem-qualcomm-palm \
"
