require exalt.inc

DEPENDS = "ecore eet ecore edbus evas wpa-supplicant dhcp"
RDEPENDS_${PN} = "wpa-supplicant dhclient"

do_stage() {
    autotools_stage_all
}
