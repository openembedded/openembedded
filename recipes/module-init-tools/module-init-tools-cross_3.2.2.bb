
require module-init-tools.inc
inherit cross
DEFAULT_PREFERENCE = "0"
PROVIDES += "virtual/${TARGET_PREFIX}depmod virtual/${TARGET_PREFIX}depmod-2.6"

# Remove the RDEPENDS we picked up from the "require";
# it's simply extraneous for the cross package
RDEPENDS_${PN} = ""

EXTRA_OECONF_append = " --program-prefix=${TARGET_PREFIX}"

do_stage () {
        oe_runmake install
        mv ${bindir}/${TARGET_PREFIX}depmod ${bindir}/${TARGET_PREFIX}depmod-2.6
}

do_install () {
        :
}
