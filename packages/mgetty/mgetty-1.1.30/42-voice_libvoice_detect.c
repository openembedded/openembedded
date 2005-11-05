--- mgetty-1.1.30.orig/voice/libvoice/detect.c	2002-12-11 22:44:38.000000000 -0800
+++ mgetty-1.1.30/voice/libvoice/detect.c	2003-09-07 14:52:01.000000000 -0700
@@ -86,6 +86,8 @@
      {ati, "Venus V.90 USB U052099a", NULL, &Lucent},
      {ati, "AEIGPM560LKTF1  Voice V2 V92cap", NULL, &V253modem},
      {ati, "Zoom V.90 PCI I030100gV -H Z207",NULL, &Lucent},
+     {ati, "Zoom V.90 PCI I052099gV -G Z207",NULL, &Lucent},
+     {ati, "Zoom V.90 Serial s052099g -I Z207", NULL, &Lucent},
      {ati, "28800",                ati6, NULL},
      {ati, "2886",                 NULL,   &US_Robotics},
      {ati, "336",                  NULL,   &Rockwell},
@@ -106,6 +108,7 @@
      {ati, "3X WYSIWYF 628DBX",    NULL,   &Rockwell},
      {ati, "56000",                NULL,   &Rockwell},
      {ati, "5601",                 NULL,   &US_Robotics},
+     {ati, "57600",                NULL,   &Multitech_2834ZDXv},
      {ati, "961",                  NULL,   &Rockwell},
      {ati, "Digi RAS modem 56000", NULL,   &Digi_RAS},
      {ati, "Linux ISDN",           NULL,   &ISDN4Linux},
@@ -114,6 +117,8 @@
 				   NULL, &Multitech_5634ZPX},
      {ati, "LT V.90 1.0 MT5634ZBAV Serial Data/Fax/Voice Modem Version 4.09a",
                                    NULL,   &Multitech_5634ZBAV},
+     {ati, "LT V.92 1.0 MT5634ZBAV-V92 Serial Data/Fax/Voice Modem Version 1.25p",
+                                   NULL,   &Multitech_5634ZBAV},
      {ati4, "33600bps Voice Modem For Italy",
                                    NULL, &Rockwell},
      {ati6, "RCV336DPFSP Rev 44BC",
