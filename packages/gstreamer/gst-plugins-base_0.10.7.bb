require gst-plugins.inc
PROVIDES_${PN} += "gst-plugins"

do_stage() {
       autotools_stage_all
}

