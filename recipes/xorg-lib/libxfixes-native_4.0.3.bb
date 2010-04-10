require libxfixes_${PV}.bb

DEPENDS = "libx11-native"
PE = "1"

inherit native

SRC_URI[archive.md5sum] = "1990d19725a3c7f32290037f02d3737f"
SRC_URI[archive.sha256sum] = "547e093c5037c4b85ce653ce26f5bd70a97b177f9b582f5351a626d8e0a829dd"
