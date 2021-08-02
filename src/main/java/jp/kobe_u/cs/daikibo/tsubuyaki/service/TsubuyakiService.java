package jp.kobe_u.cs.daikibo.tsubuyaki.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.tsubuyaki.entity.Tsubuyaki;
import jp.kobe_u.cs.daikibo.tsubuyaki.repositry.TsubuyakiRepository;

@Service
public class TsubuyakiService {
    @Autowired
    TsubuyakiRepository repo; // レポジトリ

    // つぶやきを投稿
    public Tsubuyaki postTsubuyaki(Tsubuyaki t) {
        //名前がない場合の業務ロジック
        String name = t.getName();
        if (name==null || name.length()==0) {
            t.setName("名無しさん");
        }
        t.setCreatedAt(new Date());  //作成日時をセット
        return repo.save(t); //セーブしたオブジェクトを返却
    }

    // 全つぶやきを取得
    public List<Tsubuyaki> getAllTsubuyaki() {

        Iterable<Tsubuyaki> found = repo.findAll();
        ArrayList<Tsubuyaki> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }

    // キーワードを含むつぶやきを検索
    public List<Tsubuyaki> search(String comment){

        Iterable<Tsubuyaki> found = new ArrayList<Tsubuyaki>();

        //すべてブランクだった場合は全件検索する
        if ("".equals(comment)){
            found = repo.findAll();
        }
        else {
            //上記以外の場合、BookDataDaoImplのメソッドを呼び出す
            found = repo.findByCommentContaining(comment);
        }

        ArrayList<Tsubuyaki> list = new ArrayList<>();
        found.forEach(list::add);
        return list;
    }
 }