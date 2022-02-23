import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.util.Random;

public class M implements Runnable {
    private int[] M = new int[32767];
    private JFrame frame;
    private byte var2 = 0;

    public M(JFrame frame){
        this.frame = frame;
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                var2 = 1;
                M.this.M[2] = e.getX();
                M.this.M[3] = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if ((e.getModifiersEx() & 4) > 0) {//TODO: getting modifiers liek thius might be sussy
                    M.this.M[1] = var2;
                } else {
                    M.this.M[0] = var2;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                M.this.M[2] = 0;
            }
        });
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                M.this.M[2] = e.getX();
                M.this.M[3] = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                M.this.M[2] = e.getX();
                M.this.M[3] = e.getY();
            }
        });
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                M.this.M[e.getKeyCode()] = 1;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                M.this.M[e.getKeyCode()] = 0;
            }
        });

    }

    public void start() {
        (new Thread(this)).start();
    }

    public void run() {
        try {
            Random random = new Random();
            BufferedImage bigBois = new BufferedImage(214, 120, 1);
            int[] graphicsBuffer = ((DataBufferInt)bigBois.getRaster().getDataBuffer()).getData();
            int[] blocks = new int[262144];
            random.setSeed(18295169L);

            //initialize random blocks
            for(int i = 0; i < 262144; ++i) {
                blocks[i] = i / 64 % 64 > 32 + random.nextInt(8) ? random.nextInt(8) + 1 : 0;
            }

            int[] buffer3 = new int[12288];

            for(int i = 1; i < 16; ++i) {
                int from255To160 = 255 - random.nextInt(96);

                for(int i0To47 = 0; i0To47 < 48; ++i0To47) {
                    for(int i0To15 = 0; i0To15 < 16; ++i0To15) {
                        int var3 = 9858122;
                        if (i == 4) {
                            var3 = 8355711;
                        }

                        if (i != 4 || random.nextInt(3) == 0) {
                            from255To160 = 255 - random.nextInt(96);
                        }

                        if (i == 1 && i0To47 < (i0To15 * i0To15 * 3 + i0To15 * 81 >> 2 & 3) + 18) {
                            var3 = 6990400;
                        } else if (i == 1 && i0To47 < (i0To15 * i0To15 * 3 + i0To15 * 81 >> 2 & 3) + 19) {
                            from255To160 = from255To160 * 2 / 3;
                        }

                        int var4;
                        int var5;
                        if (i == 7) {
                            var3 = 6771249;
                            if (i0To15 <= 0 || i0To15 >= 15 || (i0To47 <= 0 || i0To47 >= 15) && (i0To47 <= 32 || i0To47 >= 47)) {
                                if (random.nextInt(2) == 0) {
                                    from255To160 = from255To160 * (150 - (i0To15 & 1) * 100) / 100;
                                }
                            } else {
                                var3 = 12359778;
                                var4 = i0To15 - 7;
                                var5 = (i0To47 & 15) - 7;
                                if (var4 < 0) {
                                    var4 = 1 - var4;
                                }

                                if (var5 < 0) {
                                    var5 = 1 - var5;
                                }

                                if (var5 > var4) {
                                    var4 = var5;
                                }

                                from255To160 = 196 - random.nextInt(32) + var4 % 3 * 32;
                            }
                        }

                        if (i == 5) {
                            var3 = 11876885;
                            if ((i0To15 + i0To47 / 4 * 4) % 8 == 0 || i0To47 % 4 == 0) {
                                var3 = 12365733;
                            }
                        }

                        var4 = from255To160;
                        if (i0To47 >= 32) {
                            var4 = from255To160 / 2;
                        }

                        if (i == 8) {
                            var3 = 5298487;
                            if (random.nextInt(2) == 0) {
                                var3 = 0;
                                var4 = 255;
                            }
                        }

                        var5 = (var3 >> 16 & 255) * var4 / 255 << 16 |
                                (var3 >> 8 & 255) * var4 / 255 << 8 |
                                (var3 & 255) * var4 / 255;
                        buffer3[i0To15 + i0To47 * 16 + i * 256 * 3] = var5;
                    }
                }
            }

            float maybeX = 96.5F;
            float maybeY = 65.0F;
            float maybeZ = 96.5F;
            float x2 = 0.0F;
            float var62 = 0.0F;
            float z2 = 0.0F;
            long currentTimeMillis = System.currentTimeMillis();
            int var14 = -1;
            int var15 = 0;
            float x = 0.0F;
            float y = 0.0F;

            while(true) {
                float sin = (float)Math.sin((double)x);
                float cos = (float)Math.cos((double)x);
                float sin1 = (float)Math.sin((double)y);
                float cos1 = (float)Math.cos((double)y);

                float var26;
                int var70;
                //physics loop
                while(System.currentTimeMillis() - currentTimeMillis > 10L) {
                    float zSpeed;
                    float xSpeed;
                    if (this.M[2] > 0) {
                        zSpeed = (float)(this.M[2] - 428) / 214.0F * 2.0F;
                        xSpeed = (float)(this.M[3] - 240) / 120.0F * 2.0F;
                        float distanceThing = (float)Math.sqrt((double)(zSpeed * zSpeed + xSpeed * xSpeed)) - 1.2F;
                        if (distanceThing < 0.0F) {
                            distanceThing = 0.0F;
                        }

                        if (distanceThing > 0.0F) {
                            x += zSpeed * distanceThing / 400.0F;
                            y -= xSpeed * distanceThing / 400.0F;
                            if (y < -1.57F) {
                                y = -1.57F;
                            }

                            if (y > 1.57F) {
                                y = 1.57F;
                            }
                        }
                    }

                    currentTimeMillis += 10L;
                    zSpeed = 0.0F;
                    xSpeed = 0.0F;
                    xSpeed += (float)(this.M[87] - this.M[83]) * 0.02F;
                    zSpeed += (float)(this.M[68] - this.M[65]) * 0.02F;
                    x2 *= 0.5F;
                    var62 *= 0.99F;
                    z2 *= 0.5F;
                    x2 += sin * xSpeed + cos * zSpeed;
                    z2 += cos * xSpeed - sin * zSpeed;
                    var62 += 0.003F;

                    label265:
                    for(var70 = 0; var70 < 3; ++var70) {
                        float var25 = maybeX + x2 * (float)((var70 + 0) % 3 / 2);
                        var26 = maybeY + var62 * (float)((var70 + 1) % 3 / 2);
                        float var27 = maybeZ + z2 * (float)((var70 + 2) % 3 / 2);

                        for(int var28 = 0; var28 < 12; ++var28) {
                            int var29 = (int)(var25 + (float)(var28 >> 0 & 1) * 0.6F - 0.3F) - 64;
                            int var30 = (int)(var26 + (float)((var28 >> 2) - 1) * 0.8F + 0.65F) - 64;
                            int var31 = (int)(var27 + (float)(var28 >> 1 & 1) * 0.6F - 0.3F) - 64;
                            if (var29 < 0 || var30 < 0 || var31 < 0 || var29 >= 64 || var30 >= 64 || var31 >= 64 || blocks[var29 + var30 * 64 + var31 * 4096] > 0) {
                                if (var70 == 1) {
                                    //use pressed space
                                    if (this.M[32] > 0 && var62 > 0.0F) {
                                        this.M[32] = 0;
                                        var62 = -0.1F;
                                    } else {
                                        var62 = 0.0F;
                                    }
                                }
                                continue label265;
                            }
                        }

                        maybeX = var25;
                        maybeY = var26;
                        maybeZ = var27;
                    }
                }

                boolean var66 = false;
                boolean var68 = false;
                if (this.M[1] > 0 && var14 > 0) {
                    blocks[var14] = 0;
                    this.M[1] = 0;
                }

                if (this.M[0] > 0 && var14 > 0) {
                    blocks[var14 + var15] = 1;
                    this.M[0] = 0;
                }

                int var71;
                int var73;
                for(var70 = 0; var70 < 12; ++var70) {
                    var71 = (int)(maybeX + (float)(var70 >> 0 & 1) * 0.6F - 0.3F) - 64;
                    int var72 = (int)(maybeY + (float)((var70 >> 2) - 1) * 0.8F + 0.65F) - 64;
                    var73 = (int)(maybeZ + (float)(var70 >> 1 & 1) * 0.6F - 0.3F) - 64;
                    if (var71 >= 0 && var72 >= 0 && var73 >= 0 && var71 < 64 && var72 < 64 && var73 < 64) {
                        blocks[var71 + var72 * 64 + var73 * 4096] = 0;
                    }
                }

                var70 = -1;

                //loop through chunks?
                for(var71 = 0; var71 < 214; ++var71) {
                    var26 = (float)(var71 - 107) / 90.0F;

                    //render loop?
                    for(var73 = 0; var73 < 120; ++var73) {
                        float var74 = (float)(var73 - 60) / 90.0F;
                        float var75 = 1.0F;
                        float var76 = var75 * cos1 + var74 * sin1;
                        float var77 = var74 * cos1 - var75 * sin1;
                        float var32 = var26 * cos + var76 * sin;
                        float var33 = var76 * cos - var26 * sin;
                        int var34 = 0;
                        int var35 = 255;
                        double var36 = 20.0D;
                        float var38 = 5.0F;

                        int var39;
                        for(var39 = 0; var39 < 3; ++var39) {
                            float var40 = var32;
                            if (var39 == 1) {
                                var40 = var77;
                            }

                            if (var39 == 2) {
                                var40 = var33;
                            }

                            float var41 = 1.0F / (var40 < 0.0F ? -var40 : var40);
                            float var42 = var32 * var41;
                            float var43 = var77 * var41;
                            float var44 = var33 * var41;
                            float decimalPart = maybeX - (float)((int)maybeX);
                            if (var39 == 1) {
                                decimalPart = maybeY - (float)((int)maybeY);
                            }

                            if (var39 == 2) {
                                decimalPart = maybeZ - (float)((int)maybeZ);
                            }

                            if (var40 > 0.0F) {
                                decimalPart = 1.0F - decimalPart;
                            }

                            float var46 = var41 * decimalPart;
                            float var47 = maybeX + var42 * decimalPart;
                            float var48 = maybeY + var43 * decimalPart;
                            float var49 = maybeZ + var44 * decimalPart;
                            if (var40 < 0.0F) {
                                if (var39 == 0) {
                                    --var47;
                                }

                                if (var39 == 1) {
                                    --var48;
                                }

                                if (var39 == 2) {
                                    --var49;
                                }
                            }

                            while((double)var46 < var36) {
                                int var50 = (int)var47 - 64;
                                int var51 = (int)var48 - 64;
                                int var52 = (int)var49 - 64;
                                if (var50 < 0 || var51 < 0 || var52 < 0 || var50 >= 64 || var51 >= 64 || var52 >= 64) {
                                    break;
                                }

                                int var53 = var50 + var51 * 64 + var52 * 4096;
                                int var54 = blocks[var53];
                                if (var54 > 0) {
                                    int var67 = (int)((var47 + var49) * 16.0F) & 15;
                                    int var69 = ((int)(var48 * 16.0F) & 15) + 16;
                                    if (var39 == 1) {
                                        var67 = (int)(var47 * 16.0F) & 15;
                                        var69 = (int)(var49 * 16.0F) & 15;
                                        if (var43 < 0.0F) {
                                            var69 += 32;
                                        }
                                    }

                                    int var55 = 16777215;
                                    if (var53 != var14 || var67 > 0 && var69 % 16 > 0 && var67 < 15 && var69 % 16 < 15) {
                                        var55 = buffer3[var67 + var69 * 16 + var54 * 256 * 3];
                                    }

                                    if (var46 < var38 && var71 == this.M[2] / 4 && var73 == this.M[3] / 4) {
                                        var70 = var53;
                                        byte var65 = 1;
                                        if (var40 > 0.0F) {
                                            var65 = -1;
                                        }

                                        var15 = var65 << 6 * var39;
                                        var38 = var46;
                                    }

                                    if (var55 > 0) {
                                        var34 = var55;
                                        var35 = 255 - (int)(var46 / 20.0F * 255.0F);
                                        var35 = var35 * (255 - (var39 + 2) % 3 * 50) / 255;
                                        var36 = (double)var46;
                                    }
                                }

                                var47 += var42;
                                var48 += var43;
                                var49 += var44;
                                var46 += var41;
                            }
                        }

                        var39 = (var34 >> 16 & 255) * var35 / 255;
                        int var78 = (var34 >> 8 & 255) * var35 / 255;
                        int var79 = (var34 & 255) * var35 / 255;
                        graphicsBuffer[var71 + var73 * 214] = var39 << 16 | var78 << 8 | var79;
                    }
                }

                var14 = var70;
                Thread.sleep(2L);
//                if (!this.isActive()) {
//                    return;
//                }
                this.frame.getGraphics().drawImage(bigBois, 0, 0, 856, 480, (ImageObserver)null);
            }
        } catch (Exception ignored) {
        }
    }

//    public boolean handleEvent(Event e) {
//        byte var2 = 0;
//        switch(e.id) {
//            case 401://key press
//                var2 = 1;
//            case 402://key release
//                this.M[e.key] = var2;
//                break;

//            case 501://mouse press
//                var2 = 1;
//                this.M[2] = e.x;
//                this.M[3] = e.y;
//            case 502://mouse release
//                if ((e.modifiers & 4) > 0) {
//                    this.M[1] = var2;
//                } else {
//                    this.M[0] = var2;
//                }
//                break;
//            case 503://mouse move
//            case 506://mouse drag
//                this.M[2] = e.x;
//                this.M[3] = e.y;
//                break;
//            case 505://mouse exit
//                this.M[2] = 0;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minecraft 4K");

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(856,480));
        frame.setVisible(true);

        M m = new M(frame);
        m.start();
    }

}
