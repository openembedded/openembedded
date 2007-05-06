require gst-plugins.inc

PROVIDES += "gst-plugins"
PR = "r0"

do_stage() {
       autotools_stage_all
}

