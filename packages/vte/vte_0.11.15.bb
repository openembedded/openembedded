LICENSE = "LGPL"
MAINTAINER = "Koen Kooi <koen@linuxtogo.org>"

inherit gnome


do_stage() {
autotools_stage_all
}
