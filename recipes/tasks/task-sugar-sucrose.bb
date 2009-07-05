DESCRIPTION = "Task for complete sugar environment with core activities"

PR = "r0"

inherit task

RDEPENDS_${PN} = "\
        sugar \
#        sugar-fructose \
"
