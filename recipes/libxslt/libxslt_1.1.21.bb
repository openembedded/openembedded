require libxslt.inc
PR = "${INC_PR}.0"

do_stage () {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "59fe34e85692f71df2a38c2ee291b3ca"
SRC_URI[archive.sha256sum] = "ccefd4ceb29bb729dcaa9a9d4a86654a9134adfd29bdd72be1a9d3726efb54e0"
