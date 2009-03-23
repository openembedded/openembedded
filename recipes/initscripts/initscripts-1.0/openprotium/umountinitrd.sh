#!/bin/sh
# umount the static dev - we'd probably never use it.
#
[ -d /dev/.static/dev ] && umount /dev/.static/dev                              
#                                                                               
# if a root is found on an ext* filesystem, umount the old initrd               
#                                                                               
grep -q "/ ext" /proc/mounts                                                    
if [ $? -eq 0 ]; then
	umount /initrd                                                  
fi
