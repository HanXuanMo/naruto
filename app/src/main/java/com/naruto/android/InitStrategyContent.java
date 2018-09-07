package com.naruto.android;

import java.util.ArrayList;
import java.util.List;

//初始化游戏内容
public class InitStrategyContent {
    private List<StrategyContent>strategyContentList;

    public List<StrategyContent> getStrategyContentList() {
        return strategyContentList;
    }

    public InitStrategyContent() {
        this.strategyContentList = new ArrayList<>();
    }

    public void init()
    {
        strategyContentList.clear();
        StrategyContent cyberpunk2077=new StrategyContent("cyberpunk2077",R.drawable.cyberpunk2077_game,"\"《赛博朋克2077》是知名《巫师》系列开发商CD Projekt RED公布的一款角色扮演游戏，故事设定在黑暗的、科技极度发达的腐败未来世界中，并且兼有沙盒元素与RPG机制。\\n\"");
        strategyContentList.add(cyberpunk2077);
        StrategyContent wizard_3=new StrategyContent("wizard_3",R.drawable.wizard_3_game,"《巫师3：狂猎》将是三部曲系列的最后一作，故事将有宏大的最后结局，但并非《巫师》系列的最终作。本作采用最新的REDengine3引擎制作，玩家可以在无缝的世界里任意探索，采用非线性剧情的设定，整体规模是前作的30倍。再加上真实的角色设定，迷人的故事以及一个无需载入过程的玩家可以自由自在畅游的开放环境，我们将会把游戏体验带到一个新的高度，给玩家更加真实的体验与完完全全的代入感。");
        strategyContentList.add(wizard_3);
        StrategyContent blood_source=new StrategyContent("blood_source",R.drawable.blood_source_game,"《血源》是一款由索尼和From Software联合打造的动作角色扮演游戏。该作被誉为《恶魔之魂》与《黑暗之魂》系列的精神续作，游戏场面保持了这两款系列游戏的恐怖黑色风格。游戏的关键要素是血源以及野兽，而且游戏的地图设定保持为无缝连接，战斗不仅仅注重动作要素同时重视策略要素，可以说每一场战斗被设计的如同最终决战。另外，游戏包含线上要素，允许玩家共同探险。");
        strategyContentList.add(blood_source);
        StrategyContent detroit=new StrategyContent("detroit",R.drawable.detroit_game,"《底特律：变人》是由Quantic Dream制作的一款科幻题材互动电影。游戏的背景设定在未来的底特律，玩家将扮演三位主角卡拉、康纳和马库斯，在一个个的选择中决定他们三个会成为怎样的人，并见证当机器人拥有了情感后，世界会变成将会如何。");
        strategyContentList.add(detroit);
        StrategyContent god_of_war4=new StrategyContent("god_of_war4",R.drawable.god_of_war4_game,"《战神4》是一款由索尼制作并发行的动作冒险游戏，是《战神3》的正统续作。本作的正式名称为“God of War”，并没有数字序号，也代表了该系列的重启，但本作是系列的第四部正统作品，国内玩家更习惯使用“战神4”这个方便的叫法。对主角奎托斯来讲，这也是一个史诗级新篇章的开始。他将摆脱神的影子，作为普通人隐居北欧神话的新大陆，为了他的儿子以及新目标，奎托斯必须为生存而战斗，对抗威胁他全新人生的强大力量。");
        strategyContentList.add(god_of_war4);
        StrategyContent persona5=new StrategyContent("persona5",R.drawable.persona5_game,"《女神异闻录5》是Atlus旗下人气游戏RPG游戏，本作继续由桥野桂担任游戏导演，目黑将司为游戏作曲，副岛成记担当角色设计。游戏将以现代日本为舞台，描写年轻的“怪盗们”暗中活跃的故事，本作以RPG中少有的犯罪方为焦点讲述故事，本作的基调十分新潮，配乐、人设、配色游戏UI无一不给给玩家带来十分刺激的感官体验。");
        strategyContentList.add(persona5);
    }

}
