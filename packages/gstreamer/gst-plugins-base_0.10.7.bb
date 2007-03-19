require gst-plugins.inc

PROVIDES += "gst-plugins"
PR = "r2"

do_stage() {
       autotools_stage_all
}

