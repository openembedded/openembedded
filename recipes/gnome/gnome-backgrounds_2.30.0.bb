DESCRIPTION = "Gnome background images"
LICENSE = "GPL"
SECTION = "x11/gnome"

inherit gnome

SRC_URI[archive.md5sum] = "4d620b0d0b6498eceacaef018abdcad2"
SRC_URI[archive.sha256sum] = "c69220d2c65419c5c2cce1f80df8bb40ef2e584ef5500313f9304eb5f71e8a92"

FILES_${PN} += "${datadir}/gnome-background-properties"

