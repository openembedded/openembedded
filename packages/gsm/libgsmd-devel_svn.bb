BASEPN = "gsmd-devel"
CONFLICTNAME = "gsmd"

require gsmd.inc

PROVIDES += "libgsmd"
RPROVIDES_${PN}-tools = "lib${CONFLICTNAME}-tools"

SRC_URI += " file://024_sms-text-in-bracket.patch;patch=1;minrev=2957;maxrev=3199 \
           file://025_sms-status-report.patch;patch=1;minrev=2957;maxrev=3200 \
           file://027_phonebook-find-and-read-range-support.patch;patch=1;minrev=2957;maxrev=3202 \
           file://028_shell-phonebook-find-and-read-range-support.patch;patch=1;minrev=2957;maxrev=3203 \
           file://0001-Introduce-ports.patch;patch=1;minrev=2957 \
           file://0002-Flush-all-pending-commands-before-restarting-the-mod.patch;patch=1;minrev=2957 \
           file://0003-Correctly-segment-incoming-usock-data-into-packets.patch;patch=1;minrev=2957 \
           file://0004-Handle-read-and-write-return-values.patch;patch=1;minrev=2957 \ 
           file://0005-Add-ask-ds-option-forSMS.patch;patch=1;minrev=2957;maxrev=3201 \ 
           file://lgsm_send_fix_return_value.patch;patch=1;maxrev=3266 \
           file://install-ts-headers.patch;patch=1 \
           file://gsmd \
           file://default"

