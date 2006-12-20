require gst-plugins.inc
PROVIDES += "gst-plugins"

do_stage() {
       autotools_stage_all
}

