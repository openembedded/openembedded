DESCRIPTION = "Edje is a complex graphical design & layout library."
DEPENDS = "freetype virtual/evas virtual/ecore embryo eet edb edje-native"
LICENSE = "MIT"
PR = "r0"

inherit efl

EXTRA_OECONF = "--disable-edje-cc --enable-fb-only"
LEAD_SONAME = "libedje.so"

libraries += "libedje_edit"

BINARIES = "edje edje_ls edje_test edje_cc edje_decc edje_thumb"
