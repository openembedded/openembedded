include ${PN}.inc

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
	   file://openzaurus-branding.patch;patch=1 \
	   file://prelim-h191x-hx4700-supp.patch;patch=1;pnum=2 \
           file://include.pro"
