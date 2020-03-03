package com.example.LegendsOfAndor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFight extends AppCompatActivity {

    public static final Random RANDOM = new Random();

    private Button getDice;
    private ImageView imageDice1, imageDice2, imageDice3, imageDice4;
    private TextView playerBattleValue;// = findViewById(R.id.playerBattleValue);
    private TextView monsterBattleValue;

    private TextView player1Profile;
    private TextView player2Profile;
    private TextView player3Profile;
    private TextView player4Profile;
    private TextView player1WP;
    private TextView player2WP;
    private TextView player3WP;
    private TextView player4WP;
    private TextView player1SP;
    private TextView player2SP;
    private TextView player3SP;
    private TextView player4SP;

//    private ImageView player1d1 = findViewById(R.id.player1_d1);
//    private ImageView player1d2 = findViewById(R.id.player1_d2);
//    private ImageView player1d3 = findViewById(R.id.player1_d3);
//    private ImageView player1d4 = findViewById(R.id.player1_d4);
//    private ImageView player1d5 = findViewById(R.id.player1_d5);
//    private ImageView player2d1 = findViewById(R.id.player2_d1);
//    private ImageView player2d2 = findViewById(R.id.player2_d2);
//    private ImageView player2d3 = findViewById(R.id.player2_d3);
//    private ImageView player2d4 = findViewById(R.id.player2_d4);
//    private ImageView player2d5 = findViewById(R.id.player2_d5);
//    private ImageView player3d1 = findViewById(R.id.player3_d1);
//    private ImageView player3d2 = findViewById(R.id.player3_d2);
//    private ImageView player3d3 = findViewById(R.id.player3_d3);
//    private ImageView player3d4 = findViewById(R.id.player3_d4);
//    private ImageView player3d5 = findViewById(R.id.player3_d5);
//    private ImageView player4d1 = findViewById(R.id.player4_d1);
//    private ImageView player4d2 = findViewById(R.id.player4_d2);
//    private ImageView player4d3 = findViewById(R.id.player4_d3);
//    private ImageView player4d4 = findViewById(R.id.player4_d4);
//    private ImageView player4d5 = findViewById(R.id.player4_d5);

    private ImageView player1d1;
    private ImageView player1d2;
    private ImageView player1d3;
    private ImageView player1d4;
    private ImageView player1d5;
    private ImageView player2d1;
    private ImageView player2d2;
    private ImageView player2d3;
    private ImageView player2d4;
    private ImageView player2d5;
    private ImageView player3d1;
    private ImageView player3d2;
    private ImageView player3d3;
    private ImageView player3d4;
    private ImageView player3d5;
    private ImageView player4d1;
    private ImageView player4d2;
    private ImageView player4d3;
    private ImageView player4d4;
    private ImageView player4d5;

    private Thread t;
    MyPlayer myPlayer = MyPlayer.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_fight);
//        final HeroClass myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() = myPlayer.getPlayer().getHero().getHeroClass();
        final Hero playerHero = myPlayer.getPlayer().getHero();

//        final int currentIndex = myPlayer.getGame().getCurrentFight().getHeroes().indexOf(playerHero);
        final ArrayList<Hero> playerIndex = myPlayer.getGame().getCurrentFight().getHeroes();
//        int playersInFight = playerIndex.size();
        List<TextView> profileList = new ArrayList<TextView>();
        List<TextView> playerWPList = new ArrayList<TextView>();
        List<TextView> playerSPList = new ArrayList<TextView>();
        profileList.add(player1Profile);
        profileList.add(player2Profile);
        profileList.add(player3Profile);
        profileList.add(player4Profile);
        playerWPList.add(player1WP);
        playerWPList.add(player2WP);
        playerWPList.add(player3WP);
        playerWPList.add(player4WP);
        playerSPList.add(player1SP);
        playerSPList.add(player2SP);
        playerSPList.add(player3SP);
        playerSPList.add(player4SP);

        final List<ImageView> player1Dice = new ArrayList<ImageView>();
        final List<ImageView> player2Dice = new ArrayList<ImageView>();
        final List<ImageView> player3Dice = new ArrayList<ImageView>();
        final List<ImageView> player4Dice = new ArrayList<ImageView>();
        player1Dice.add(player1d1);
        player1Dice.add(player1d2);
        player1Dice.add(player1d3);
        player1Dice.add(player1d4);
        player1Dice.add(player1d5);
        player2Dice.add(player2d1);
        player2Dice.add(player2d2);
        player2Dice.add(player2d3);
        player2Dice.add(player2d4);
        player2Dice.add(player2d5);
        player3Dice.add(player3d1);
        player3Dice.add(player3d2);
        player3Dice.add(player3d3);
        player3Dice.add(player3d4);
        player3Dice.add(player3d5);
        player4Dice.add(player4d1);
        player4Dice.add(player4d2);
        player4Dice.add(player4d3);
        player4Dice.add(player4d4);
        player4Dice.add(player4d5);



        //Hides text for user, WP, SP, until player joins the fight
        for (int i = 0; i < playerIndex.size(); i++) {
            int playerNumber = i + 1;
            String playerPosition = "player" + playerNumber;
            String playerWPText = "player" + playerNumber + "_wp";
            String playerSPText = "player" + playerNumber + "_sp";
            int playerProfileID = getResources().getIdentifier(playerPosition, "id", getPackageName());
            int playerWPID = getResources().getIdentifier(playerWPText, "id", getPackageName());
            int playerSPID = getResources().getIdentifier(playerSPText, "id", getPackageName());
            TextView userProfile = profileList.get(i);
            TextView userWP = playerWPList.get(i);
            TextView userSP = playerSPList.get(i);
            userProfile.setVisibility(View.INVISIBLE);
            userWP.setVisibility(View.INVISIBLE);
            userSP.setVisibility(View.INVISIBLE);
        }

        //Adds information for participating players, making their profiles visible
        for (int i = 0; i < playerIndex.size(); i++) {
            Hero currentPlayer = playerIndex.get(i);
            int playerNumber = i + 1;
            String playerPosition = "player" + playerNumber;
            String playerWPText = "player" + playerNumber + "_wp";
            String playerSPText = "player" + playerNumber + "_sp";
            int playerProfileID = getResources().getIdentifier(playerPosition, "id", getPackageName());
            int playerWPID = getResources().getIdentifier(playerWPText, "id", getPackageName());
            int playerSPID = getResources().getIdentifier(playerSPText, "id", getPackageName());
            TextView userProfile = profileList.get(i);
            TextView userWP = playerWPList.get(i);
            TextView userSP = playerSPList.get(i);
            userProfile = findViewById(playerProfileID);
            userWP = findViewById(playerWPID);
            userSP = findViewById(playerSPID);
            String currentWP = "WP: " + currentPlayer.getWillPower();
            String currentSP = "SP: " + currentPlayer.getStrength();
            userProfile.setText(currentPlayer.getHeroClass().toString());
            userWP.setText(currentWP);
            userSP.setText(currentSP);
            userProfile.setVisibility(View.VISIBLE);
            userWP.setVisibility(View.VISIBLE);
            userSP.setVisibility(View.VISIBLE);
        }


        getDice = findViewById(R.id.get_dice);

        //Retrieves the amount of dice for the current player class
        getDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView currentD1;
                ImageView currentD2;
                ImageView currentD3;
                ImageView currentD4;
                ImageView currentD5;

//                for (int i = 0; i< playerIndex.size(); i++) {
//                    if (myPlayer.getPlayer().getHero() == playerIndex.get(i)) {
//                        int playerNum = i + 1;
//                        if (playerNum == 1) {
//                            currentD1 = player1Dice.get(i);
//                            currentD1 = player1Dice.get(i);
//                        } else {
//                            currentD1 = player4Dice.get(i);
//                            currentD2 = player4Dice.get(i);
//                        }
//                    }
//                }

                for (int i = 0; i < playerIndex.size(); i++) {
                    if (myPlayer.getPlayer().getHero() == playerIndex.get(i)) {
                        int playerNum = i + 1;
                        String diceNum1 = "player" + playerNum + "_d" + 1;
                        String diceNum2 = "player" + playerNum + "_d" + 2;
                        String diceNum3 = "player" + playerNum + "_d" + 3;
                        String diceNum4 = "player" + playerNum + "_d" + 4;
                        String diceNum5 = "player" + playerNum + "_d" + 5;
                        int d1TV = getResources().getIdentifier(diceNum1, "id", getPackageName());
                        int d2TV = getResources().getIdentifier(diceNum2, "id", getPackageName());
                        int d3TV = getResources().getIdentifier(diceNum3, "id", getPackageName());
                        int d4TV = getResources().getIdentifier(diceNum4, "id", getPackageName());
                        int d5TV = getResources().getIdentifier(diceNum5, "id", getPackageName());

                        if (playerNum == 1) {
                            currentD1 = player1Dice.get(i);
                            currentD2 = player1Dice.get(i);
                            currentD3 = player1Dice.get(i);
                            currentD4 = player1Dice.get(i);
                            currentD5 = player1Dice.get(i);
                            int wp = myPlayer.getPlayer().getHero().getWillPower();
                            if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.WARRIOR) {
                            //if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.WARRIOR) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.ARCHER) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD5.findViewById(d5TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                    currentD5.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.DWARF) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                }
                            } else { //if WIZARD
                                currentD1.findViewById(d1TV);
                                currentD1.setVisibility(View.VISIBLE);
                            }

                        } else if (playerNum == 2) {
                            currentD1 = player2Dice.get(i);
                            currentD2 = player2Dice.get(i);
                            currentD3 = player2Dice.get(i);
                            currentD4 = player2Dice.get(i);
                            currentD5 = player2Dice.get(i);
                            int wp = myPlayer.getPlayer().getHero().getWillPower();
                            if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.WARRIOR) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.ARCHER) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD5.findViewById(d5TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                    currentD5.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.DWARF) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                }
                            } else { //if WIZARD
                                currentD1.findViewById(d1TV);
                                currentD1.setVisibility(View.VISIBLE);
                            }

                        } else if (playerNum == 3) {
                            currentD1 = player3Dice.get(i);
                            currentD2 = player3Dice.get(i);
                            currentD3 = player3Dice.get(i);
                            currentD4 = player3Dice.get(i);
                            currentD5 = player3Dice.get(i);
                            int wp = myPlayer.getPlayer().getHero().getWillPower();
                            if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.WARRIOR) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.ARCHER) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD5.findViewById(d5TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                    currentD5.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.DWARF) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                }
                            } else { //if WIZARD
                                currentD1.findViewById(d1TV);
                                currentD1.setVisibility(View.VISIBLE);
                            }

                        } else {
                            currentD1 = player4Dice.get(i);
                            currentD2 = player4Dice.get(i);
                            currentD3 = player4Dice.get(i);
                            currentD4 = player4Dice.get(i);
                            currentD5 = player4Dice.get(i);
                            int wp = myPlayer.getPlayer().getHero().getWillPower();
                            if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.WARRIOR) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.ARCHER) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD4.findViewById(d4TV);
                                    currentD5.findViewById(d5TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                    currentD4.setVisibility(View.VISIBLE);
                                    currentD5.setVisibility(View.VISIBLE);
                                }
                            } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.DWARF) {
                                if (wp <= 6) {
                                    currentD1.findViewById(d1TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                } else if (wp > 6 && wp <= 13) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                } else if (wp >= 14) {
                                    currentD1.findViewById(d1TV);
                                    currentD2.findViewById(d2TV);
                                    currentD3.findViewById(d3TV);
                                    currentD1.setVisibility(View.VISIBLE);
                                    currentD2.setVisibility(View.VISIBLE);
                                    currentD3.setVisibility(View.VISIBLE);
                                }
                            } else { //if WIZARD
                                currentD1.findViewById(d1TV);
                                currentD1.setVisibility(View.VISIBLE);
                            }

                        }

//                        int wp = myPlayer.getPlayer().getHero().getWillPower();
//                        if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.WARRIOR) {
//                            if (wp <= 6) {
//                                currentD1.findViewById(d1TV);
//                                currentD2.findViewById(d2TV);
//                            } else if (wp <= 13) {
//
//                            } else if (wp >= 14) {
//
//                            }
//                        } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.ARCHER) {
//                            if (wp <= 6) {
//
//                            } else if (wp <= 13) {
//
//                            } else if (wp >= 14) {
//
//                            }
//                        } else if (myPlayer.getGame().getCurrentFight().getHeroes().get(i).getHeroClass() == HeroClass.DWARF) {
//                            if (wp <= 6) {
//
//                            } else if (wp <= 13) {
//
//                            } else if (wp >= 14) {
//
//                            }
//                        } else { //if WIZARD
//
//                        }
                    }
                }


            }
        });

//        Button attack = findViewById(R.id.attack_btn);
//        attack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                int valuePlayer = randomDiceValue();
//                int playerDice1 = randomDiceValue();
//                int playerDice2 = randomDiceValue();
//                int playerDice3 = randomDiceValue();
//                int playerDice4 = randomDiceValue();
//
//                int monsterRoll1 = randomDiceValue();
//                int monsterRoll2 = randomDiceValue();
//                int monsterRoll3 = randomDiceValue();
//                int monsterRoll4 = randomDiceValue();
//
////                int valueMonster = randomDiceValue();
//
////                int res1 = getResources().getIdentifier("dice_" + valuePlayer, "drawable", "com.example.LegendsOfAndor");
////                int res2 = getResources().getIdentifier("dice_" + valueMonster, "drawable", "com.example.LegendsOfAndor");
//                final String dice1 = "dice_" + playerDice1;
//                final String dice2 = "dice_" + playerDice2;
//                final String dice3 = "dice_" + playerDice3;
//                final String dice4 = "dice_" + playerDice4;
//
////                imageView1.setImageResource(res1);
////                imageView2.setImageResource(res2);
//
//                imageDice1.setImageDrawable(getResources().getDrawable(getResourceID(dice1, "drawable", getApplicationContext())));
//                imageDice2.setImageDrawable(getResources().getDrawable(getResourceID(dice2, "drawable", getApplicationContext())));
//
//                playerBattleValue = findViewById(R.id.playerBattleValue);
//                monsterBattleValue = findViewById(R.id.monsterBattleValue);
//
//                int battleValueSum = Math.max(Math.max(playerDice1, playerDice2), Math.max(playerDice3, playerDice4));
//                //Strength points of hero need to be added to battleValueSum
//
//                int monsterValueSum = monsterRoll1 + monsterRoll2;
//                playerBattleValue.setText(Integer.toString(battleValueSum));
//                monsterBattleValue.setText(Integer.toString(monsterValueSum));
//
//
//            }
//        });
    }
    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    protected final static int getResourceID(final String resName, final String resType, final Context ctx) {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException("No resource string found with name " + resName);
        }
        else {
            return ResourceID;
        }
    }
}
