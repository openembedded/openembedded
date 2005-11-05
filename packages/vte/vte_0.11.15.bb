LICENSE = "LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

inherit gnome


do_stage() {
autotools_stage_all
}
