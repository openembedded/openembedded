require cornucopia.inc
inherit fso-plugin
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.9.5+gitr${SRCPV}"
PE = "1"
PR = "${INC_PR}.1"

do_configure_append_aurora() {
  # Fix configuration for aurora distribution as other distros get's broken by this
  sed -i -e 's/^enable_shadow_resources.*$/enable_shadow_resources = 1/g' ${S}/conf/palm_pre/fsousaged.conf
}
