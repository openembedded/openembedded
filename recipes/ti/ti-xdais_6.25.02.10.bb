require ti-xdais.inc

PV = "6_25_02_10_eng"

SRC_URI[xdaistarball.md5sum] = "0c3f2d4c52b6007ddd53981aa6976de5"
SRC_URI[xdaistarball.sha256sum] = "1ca3b4c5b57f777614977c2eae1befe444b0f861e105f76f678790a1a1339ba7"

# Engineering build - SRC_URI is not public yet - override link
HTTP_PROXY_IGNORE="www.sanb.design.ti.com"
SRC_URI = "http://www.sanb.design.ti.com/tisb_releases/XDAIS/${PV}/exports/xdais_${PV}.tar.gz;name=xdaistarball"

