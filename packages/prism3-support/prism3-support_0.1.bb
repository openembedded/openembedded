DESCRIPTION = "meta-package for prism3 support through ifupdown and hostap_fw_load"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "prism3-firmware hostap-utils"
RDEPENDS = "prism3-firmware hostap-utils"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

do_install() {
	install -d ${D}/${sysconfdir}/network/if-pre-up.d/
	cat >${D}/${sysconfdir}/network/if-pre-up.d/hostap-fw-load <<EOF
#!/bin/sh
                                                       
# Special case for prism3 cards needing firmware upload
# Add more known manfids, if necessary          
                                                       
if [ `cardctl info|grep "d601,0010\|d601,0101"` ]; then
  iwpriv "$IFACE" reset 1                             
  hostap_fw_load "$IFACE"  
fi                      
  
# lets hope that run-parts obeys the order :D
EOF
	chmod a+rx ${D}/${sysconfdir}/network/if-pre-up.d/hostap-fw-load
}

