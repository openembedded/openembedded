 void init_leds(void);
 void led_on(int);
 void led_off( int );
 void led_toggle(int num);

 // ioctls -- 'M" is used for sound cards...we don't got one so it seems safe
 #define N2_LM_OFF               _IOW('M',32,long)
 #define N2_LM_ON                _IOW('M',33,long)
 #define N2_LM_BLINK             _IOW('M',34,long)
 #define N2_LM_ALT               _IOW('M',35,long)
 #define N2_LM_ALL_ON            _IO('M',36)
 #define N2_LM_ALL_OFF           _IO('M',37)

 // The LED names for switches
 #define LED_RS_RED              0
 #define LED_RS_GRN              1
 #define LED_DISK1               2
 #define LED_DISK2               3
 #define LED_ALL                 4

 #define PHYS_LEDS               4
