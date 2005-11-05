include ecore-fb_${PV}.bb
inherit native
# disable curl for now (see EXTRA_OECONF in ecore-fb), we may reenable it when we need it
# DEPENDS = "curl-native eet-native evas-native"
DEPENDS = "eet-native evas-native"
PROVIDES = "ecore-native"