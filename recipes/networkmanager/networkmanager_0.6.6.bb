require networkmanager.inc

PR = "r7"

# Release candidate for 0.6.6, Hosted in dcbw's redhat space. 
SRC_URI = "http://people.redhat.com/dcbw/NetworkManager/0.6.6/NetworkManager-0.6.6.tar.gz \
	       file://25NetworkManager \
	       file://99_networkmanager \
           file://fix_seg_fault.patch;patch=1 \
          "

SRC_URI_append_mamona = " \
                    file://avoid_frequent_scan.patch;patch=1 \
                    file://adding_no_scan_by_default.patch;patch=1 \
                  "

SRC_URI_append_nokia770 = " file://cx3110_bring_up.patch;patch=1 "
SRC_URI_append_nokia800 = " file://cx3110_bring_up.patch;patch=1 "
SRC_URI_append_nokia810 = " file://cx3110_bring_up.patch;patch=1 "
